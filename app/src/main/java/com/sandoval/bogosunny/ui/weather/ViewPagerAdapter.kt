package com.sandoval.bogosunny.ui.weather

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.sandoval.bogosunny.ui.base.BaseFragment

class ViewPagerAdapter(manager: FragmentManager) :
    FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = mutableListOf<BaseFragment>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItemPosition(any: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    fun addFragment(fragment: BaseFragment) {
        fragmentList.add(fragment)
        notifyDataSetChanged()
    }

    fun removeFragments() {
        fragmentList.clear()
        notifyDataSetChanged()
    }

}