import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a08ex04.R

class CustomAdapter(private val userList: List<User>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.nome)
        val userId: TextView = itemView.findViewById(R.id.usuario)
        val userAvatar: ImageView = itemView.findViewById(R.id.foto)
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false))
    }

    // Binds each user in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = userList[position]
        holder.userName.text = user.name.toString()
        holder.userId.text = user.login.toString()

        // Use Glide library to load user avatar into the ImageView
        Glide.with(holder.userAvatar.context)
            .load(user.avatar_url)
            .into(holder.userAvatar)
    }

    // Gets the number of users in the list
    override fun getItemCount(): Int {
        return userList.size
    }
}
