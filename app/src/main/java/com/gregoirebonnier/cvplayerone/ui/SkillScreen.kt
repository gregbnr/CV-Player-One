package com.gregoirebonnier.cvplayerone.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.gregoirebonnier.cvplayerone.R
import com.gregoirebonnier.cvplayerone.ui.tools.ExpandableCardSkill

class SkillScreen() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Skills",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.surface)
                ) {
                    item {
                        ExpandableCardSkill(
                            header = "Android",
                            skills = androidSkills,
                            imageRes = R.drawable.ic_baseline_android_24,
                        )
                        ExpandableCardSkill(
                            header = "Code Architecture",
                            skills = architectureSkills,
                            imageRes = R.drawable.ic_baseline_cleaning_services_24,
                        )
                        ExpandableCardSkill(
                            header = "Management",
                            skills = managementSkills,
                            imageRes = R.drawable.ic_baseline_manage_accounts_24,
                        )
                        ExpandableCardSkill(
                            header = "Web",
                            skills = webSkills,
                            imageRes = R.drawable.ic_baseline_computer_24,
                        )
                        ExpandableCardSkill(
                            header = "Knowledge",
                            skills = knowledgeSkills,
                            imageRes = R.drawable.ic_baseline_lightbulb_24,
                        )
                    }
                }
            }
        )
    }

    private val androidSkills = listOf(
        "Kotlin",
        "Java",
        "Couroutines Flow",
        "Jetpack Compose",
        "Databinding",
        "Espresso",
        "Mockk",
        "Kakao",
        "Room",
        "Retrofit",
        "Koin Injection",
        "Koin Test",
        "Git",
    )

    private val architectureSkills = listOf(
        "MVVM",
        "MVI",
        "Clean Architecture",
    )

    private val webSkills = listOf(
        "HTML",
        "CSS",
        "JS",
    )

    private val knowledgeSkills = listOf(
        "Flutter",
        "SQLite",
        "Worker",
    )

    private val managementSkills = listOf(
        "Agility Management",
        "Jira",
        "Team management",
        "Planning",
        "Quotation",
        "Invoicing",
        "Acceptance, support call for tender",
        "Retroplanning of projects"
    )


}