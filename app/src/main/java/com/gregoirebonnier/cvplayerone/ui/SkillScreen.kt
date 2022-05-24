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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.gregoirebonnier.cvplayerone.R
import com.gregoirebonnier.cvplayerone.ui.tools.ExpandableCardSkill

class SkillScreen() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {

        val androidSkills = listOf(
            "Kotlin",
            "Java",
            "Couroutines Flow",
            "Jetpack Compose",
            "Databinding",
            "Espresso",
            "Mockk",
            "Kakao",
            "Turbine",
            "Robolectric",
            "Room",
            "Datastore",
            "Retrofit",
            "Koin Injection",
            "Koin Test",
            "Git",
        )

        val architectureSkills = listOf(
            "MVVM",
            "MVI",
            "Clean Architecture",
        )

        val webSkills = listOf(
            "HTML",
            "CSS",
            "JS",
        )

        val knowledgeSkills = listOf(
            "Flutter",
            "Swift",
            "SQLite",
            "Worker",
        )

        val lifeSkills = listOf(
            stringResource(R.string.skillScreen_skill_smiling),
            stringResource(R.string.skillScreen_skill_curious),
            "Sociable",
            stringResource(R.string.skillScreen_skill_psg),
        )

        val managementSkills = listOf(
            stringResource(R.string.skillScreen_skill_agility),
            "Jira",
            stringResource(R.string.skillScreen_skill_team),
            "Planning",
            stringResource(R.string.skillScreen_skill_quotation),
            stringResource(R.string.skillScreen_skill_invoicing),
            stringResource(R.string.skillScreen_skill_acceptance),
            stringResource(R.string.skillScreen_skill_retroplanning)
        )

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
                            header = stringResource(R.string.skillScreen_title_knowledge),
                            skills = knowledgeSkills,
                            imageRes = R.drawable.ic_baseline_lightbulb_24,
                        )
                        ExpandableCardSkill(
                            header = stringResource(R.string.skillScreen_title_myself),
                            skills = lifeSkills,
                            imageRes = R.drawable.ic_baseline_nightlife_24,
                        )
                    }
                }
            }
        )

    }

}