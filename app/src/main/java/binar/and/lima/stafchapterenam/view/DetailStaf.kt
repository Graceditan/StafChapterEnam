package binar.and.lima.stafchapterenam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.and.lima.stafchapterenam.R
import binar.and.lima.stafchapterenam.model.GetAllStafResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_staf.*
import kotlinx.android.synthetic.main.item_staf.*

class DetailStaf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_staf)

        getDetail()
    }

    fun getDetail(){
        val detail = intent.getParcelableExtra<GetAllStafResponseItem>("detailstaf")

        tv_detalnamastaf.text = detail?.name
        tv_tanggalstaf.text = detail?.createdAt
        tv_detalemailstaf.text = detail?.email
        Glide.with(this).load(detail?.image).into(img_staf)
    }
}