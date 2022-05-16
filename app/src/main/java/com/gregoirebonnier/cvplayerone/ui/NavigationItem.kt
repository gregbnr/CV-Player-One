package com.gregoirebonnier.cvplayerone.ui

import com.gregoirebonnier.cvplayerone.R

sealed class NavigationItem(var route: String, var icon: Int, var title: Int) {
    object Profile : NavigationItem("home",
        R.drawable.ic_baseline_person_24,
        R.string.navigationItem_title_profile)

    object Experiences : NavigationItem("music",
        R.drawable.ic_baseline_work_24,
        R.string.navigationItem_title_experiences)

    object Skills : NavigationItem("movies",
        R.drawable.ic_baseline_checklist_rtl_24,
        R.string.navigationItem_title_skills)
}