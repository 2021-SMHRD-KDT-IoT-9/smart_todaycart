import com.example.todaycart.ProductVO
import com.example.todaycart.R
import com.example.todaycart.ShoppingActivity

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(val context: Context, val layout : Int, val products1 : ArrayList<ProductVO>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var currentQuantity: Int = 1
    private var newQuantity: Int = 0
    private val inflater = LayoutInflater.from(context)
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    private var totalPrice :Int = 0
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val productName : TextView = view.findViewById(R.id.productName) // 제품 이름
        val cost : TextView = view.findViewById(R.id.cost) // 제품 가격
        val quantity : TextView = view.findViewById(R.id.quantity) // 제품 갯수
        val img2 : ImageView = view.findViewById(R.id.img2) // 제품 사진
        val btnPlus : Button = view.findViewById(R.id.btnPlus) // 숫자 증가 버튼
        val btnMinus : Button = view.findViewById(R.id.btnMinus) // 숫자 감소 버튼
        val btnDelete : Button = view.findViewById(R.id.btnDelete) // 상품 리스트 삭제 버튼
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.shopping_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products1.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products1[position]
        val shoppingActivity = context as ShoppingActivity
        holder.cost.text = product.p_price.toString()
        holder.productName.text = product.p_name
        Glide.with(context)
            .load("http://119.200.31.135:9090/project/productUpload"+product.p_img) // 이미지 URL
            .placeholder(R.drawable.snack) // 로딩 중 표시할 이미지
            .error(R.drawable.snack) // 오류 시 표시할 이미지
            .into(holder.img2)
        holder.btnDelete.setOnClickListener {
            products1.removeAt(position)
            notifyDataSetChanged()
            if(products1.size == 0){
                Toast.makeText(shoppingActivity,"장바구니에 물품이 없습니다!",Toast.LENGTH_SHORT).show()
            }
        }
        holder.btnPlus.setOnClickListener {
            currentQuantity = holder.quantity.text.toString().toInt()
            newQuantity = currentQuantity + 1
            holder.quantity.text = newQuantity.toString()
            var amount = holder.quantity.text.toString().toInt()
            val price = holder.cost.text.toString().toInt()
            totalPrice = price* amount
            shoppingActivity.changeCost(totalPrice)
            saveCartData(amount)
            savemoney(totalPrice)
        }
        holder.btnMinus.setOnClickListener {
            currentQuantity = holder.quantity.text.toString().toInt()
            if (currentQuantity > 0) {
                newQuantity = currentQuantity - 1
                holder.quantity.text = newQuantity.toString()
                val shoppingActivity = context as ShoppingActivity
                var amount = holder.quantity.text.toString().toInt()
                val price = holder.cost.text.toString().toInt()
                totalPrice = price*amount
                shoppingActivity.changeCost(totalPrice)
                saveCartData(amount)
                savemoney(totalPrice)
            }
        }
    }
    private fun saveCartData(quantity: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("quantity", quantity)
        editor.apply()
    }

    private fun savemoney(totalPrice: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("totalCost", totalPrice)
        editor.apply()
    }
}