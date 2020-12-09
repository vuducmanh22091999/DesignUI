package com.example.designui.ui.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.designui.ui.details.tab.AllFragment
import com.example.designui.ui.details.tab.ExpenseFragment
import com.example.designui.ui.details.tab.IncomeFragment

class DetailsViewPager(
    fragmentManager: FragmentManager,
    private val listTitle: MutableList<String>
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = listTitle.size
    override fun getItem(position: Int): Fragment {
        return when (listTitle[position]) {
            "All" -> AllFragment()
            "Income" -> IncomeFragment()
            else -> ExpenseFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? = listTitle[position]
}