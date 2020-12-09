package com.example.designui.ui.details

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.designui.R
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private var fragmentName = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    init {
        fragmentName.addAll(
            mutableListOf(
                "All", "Income", "Expense"
            )
        )
    }

    private fun setUpView() {
        viewPager.adapter = DetailsViewPager(childFragmentManager, fragmentName)
        tabLayout.setupWithViewPager(viewPager)
    }
}