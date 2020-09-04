package cookode.instagram_clone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.squareup.picasso.Picasso
import cookode.instagram_clone.model.User
import de.hdodenhof.circleimageview.CircleImageView
import idn.project.instagramclone.R

class UserAdapter(private var mContext: Context, private var mUser: List<User>,
                  private var isFragment: Boolean = false): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.user_item_layout,parent,  false)
        return UserAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = mUser[position]
        holder.userNametxtView.text = user.username
        holder.fullNametxtView.text = user.fullname
        Picasso.get().load(user.image).placeholder(R.drawable.profile).into(holder.userProfileImage)

        cekFollowingStatus(user.uid, holder.followButton)
    }

    private fun cekFollowingStatus(uid: String, followButton: Button) {

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userNametxtView = itemView.findViewById<TextView>(R.id.user_fullname_search)
        var fullNametxtView = itemView.findViewById<TextView>(R.id.user_fullname_search)
        var userProfileImage: CircleImageView = itemView.findViewById(R.id.user_profile_image_search)
        var followButton: Button = itemView.findViewById(R.id.follow_btnsearch)

    }


}