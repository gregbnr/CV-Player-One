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
import com.gregoirebonnier.cvplayerone.ui.tools.ExpandableCard

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
                        ExpandableCard(
                            header = "Android",
                            skills = androidSkills,
                            isHorizontalChips = false,
                        )
                        ExpandableCard(
                            header = "Code Architecture",
                            skills = architectureSkills,
                            isHorizontalChips = false,
                        )
                        ExpandableCard(
                            header = "Management",
                            skills = managementSkills,
                            isHorizontalChips = false,
                        )
                        ExpandableCard(
                            header = "Web",
                            skills = webSkills,
                            isHorizontalChips = false,
                        )
                        ExpandableCard(
                            header = "Knowledge",
                            skills = knowledgeSkills,
                            isHorizontalChips = false,
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