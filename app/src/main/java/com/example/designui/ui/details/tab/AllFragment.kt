package com.example.designui.ui.details.tab

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

class AllFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        tvSeeDetails.setOnClickListener(this)
    }

    private fun test() {
        val layoutParams = imgAround.layoutParams as ConstraintLayout.LayoutParams
        val startAngle = layoutParams.circleAngle
        val endAngle = startAngle + 360

        val aim = ValueAnimator.ofFloat(startAngle, endAngle)
        aim.addUpdateListener { valueAnimator ->
            val animatedValue = valueAnimator.animatedValue as Float
            val layoutParams = imgAround.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.circleAngle = animatedValue
            imgAround.layoutParams = layoutParams

            imgTest.rotation = (animatedValue % 360 - 270)

            imgAround.rotation = (animatedValue % 360 - 270)

        }
        aim.duration = 2000

        aim.interpolator = LinearInterpolator()
        aim.repeatMode = ValueAnimator.RESTART
        aim.repeatCount = ValueAnimator.INFINITE
        aim.start()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tvSeeDetails -> test()
        }
    }
}