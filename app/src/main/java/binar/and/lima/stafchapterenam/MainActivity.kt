package binar.and.lima.stafchapterenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.and.lima.stafchapterenam.model.GetAllStafResponseItem
import binar.and.lima.stafchapterenam.presenter.StafPresenter
import binar.and.lima.stafchapterenam.presenter.StafView
import binar.and.lima.stafchapterenam.view.AdapterStaf
import binar.and.lima.stafchapterenam.view.DetailStaf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StafView {

    private lateinit var presenterstaf : StafPresenter
    lateinit var adapterstaf : AdapterStaf
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterstaf = StafPresenter(this)
        presenterstaf.getDataStaf()
    }

    override fun onSuccess(pesan: String, staf: List<GetAllStafResponseItem>) {
        rvstaf.layoutManager = LinearLayoutManager(this)
        adapterstaf = AdapterStaf(staf){
            val pindah = Intent(this@MainActivity, DetailStaf::class.java)
            pindah.putExtra("detailstaf", it)
            startActivity(pindah)
        }
        rvstaf.adapter = adapterstaf
    }
    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }
}