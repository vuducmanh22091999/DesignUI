package com.example.designui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designui.R
import com.example.designui.ui.details.DetailsFragment
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var statusAdapter: StatusAdapter
    private var listStatus: ArrayList<Status> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initListener()
        getDate()
    }

    private fun initListener() {
        tvOverview.setOnClickListener(this)
    }

    private fun switchDetails() {
        requireActivity().supportFragmentManager.beginTransaction().add(R.id.flContentScreen, DetailsFragment())
            .addToBackStack(null).commit()
    }

    private fun getDate() {
        val currentDateTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("MMM dd, YYYY", Locale.getDefault())
        tvDate.text = dateFormat.format(currentDateTime)
    }

    private fun initRecyclerView() {
        listStatus.add(Status(R.drawable.ic_up_arrow, "Sent", "Sending Payment to Clients", "$150"))
        listStatus.add(
            Status(
                R.drawable.ic_down_arrow,
                "Receive",
                "Receiving Salary from Company",
                "$250"
            )
        )
        listStatus.add(Status(R.drawable.ic_loan, "Loan", "Loan for the car", "$400"))
        listStatus.add(
            Status(
                R.drawable.ic_down_arrow,
                "Receive",
                "Receiving Salary from Company",
                "$550"
            )
        )
        listStatus.add(Status(R.drawable.ic_up_arrow, "Sent", "Sending Payment to Clients", "$150"))
        listStatus.add(Status(R.drawable.ic_loan, "Loan", "Loan to Clients", "$150"))
        listStatus.add(
            Status(
                R.drawable.ic_down_arrow,
                "Receive",
                "Receiving Salary from Company",
                "$750"
            )
        )
        listStatus.add(Status(R.drawable.ic_up_arrow, "Sent", "Sending Payment to Clients", "$150"))
        listStatus.add(
            Status(
                R.drawable.ic_down_arrow,
                "Receive",
                "Receiving Salary from Company",
                "$1950"
            )
        )
        listStatus.add(Status(R.drawable.ic_loan, "Loan", "Loan for the car", "$900"))
        listStatus.add(Status(R.drawable.ic_up_arrow, "Sent", "Sending Payment to Clients", "$150"))
        listStatus.add(Status(R.drawable.ic_loan, "Loan", "Loan for the car", "$1500"))

        statusAdapter = StatusAdapter(listStatus)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcvStatus.layoutManager = linearLayoutManager
        rcvStatus.setHasFixedSize(true)
        rcvStatus.adapter = statusAdapter
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.tvOverview -> switchDetails()
        }
    }


}