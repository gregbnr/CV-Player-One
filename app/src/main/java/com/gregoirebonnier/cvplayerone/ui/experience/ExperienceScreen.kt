package com.gregoirebonnier.cvplayerone.ui.experience

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
import com.gregoirebonnier.cvplayerone.domain.model.CompanyModel
import com.gregoirebonnier.cvplayerone.ui.tools.ExpandableCardExperience

class ExperienceScreen() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {

        val companyOptimetriks = CompanyModel(
            name = "Optimetriks",
            role = stringResource(id = R.string.profileScreen_informationItem_title_developer),
            period = "2020-2022",
            missionList = listOf(
                stringResource(R.string.experienceScreen_company_mission_modularisation),
                stringResource(R.string.experienceScreen_company_mission_quality),
                stringResource(R.string.experienceScreen_company_mission_facilitating),
                stringResource(R.string.experienceScreen_company_mission_design),
                stringResource(R.string.experienceScreen_company_mission_specification),
            ),
            skillsList = listOf(
                "Kotlin",
                "Java",
                "Couroutines Flow",
                "MVVM",
                "MVI",
                "Clean Architecture",
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
                stringResource(id = R.string.skillScreen_skill_agility),
                "Jira",
            ),
            imageRes = R.drawable.fieldpro,
        )

        val companyWonderstudios2 = CompanyModel(
            name = "Wonderstudios",
            role = stringResource(R.string.experienceScreen_company_role_manager),
            period = "2019-2020",
            missionList = listOf(
                stringResource(R.string.experienceScreen_company_mission_relation),
                stringResource(R.string.experienceScreen_company_mission_consulting),
                stringResource(R.string.experienceScreen_company_mission_web),
                stringResource(R.string.experienceScreen_company_mission_monotoring),
            ),
            skillsList = listOf(
                stringResource(id = R.string.skillScreen_skill_team),
                "Planning",
                stringResource(id = R.string.skillScreen_skill_quotation),
                stringResource(id = R.string.skillScreen_skill_invoicing),
                stringResource(id = R.string.skillScreen_skill_acceptance),
                stringResource(id = R.string.skillScreen_skill_retroplanning),
            ),
            imageRes = R.drawable.wonderstudios,
        )

        val companyWonderstudios1 = CompanyModel(
            name = "Wonderstudios",
            role = stringResource(R.string.experienceScreen_company_role_web),
            period = "2018-2019",
            missionList = listOf(
                stringResource(R.string.experienceScreen_company_mission_ad),
                stringResource(R.string.experienceScreen_company_mission_graphic),
                stringResource(R.string.experienceScreen_company_mission_training),
            ),
            skillsList = listOf(
                "HTML",
                "CSS",
                "JS",
                "Photoshop",
                "Illustrator",
                stringResource(R.string.experienceScreen_company_skill_manager),
            ),
            imageRes = R.drawable.wonderstudios,
        )


        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Experiences",
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
                        ExpandableCardExperience(
                            header = companyOptimetriks.name,
                            subtitle = companyOptimetriks.role,
                            date = companyOptimetriks.period,
                            description = companyOptimetriks.missionList,
                            skills = companyOptimetriks.skillsList,
                            imageRes = companyOptimetriks.imageRes,
                        )
                        ExpandableCardExperience(
                            header = companyWonderstudios2.name,
                            subtitle = companyWonderstudios2.role,
                            date = companyWonderstudios2.period,
                            description = companyWonderstudios2.missionList,
                            skills = companyWonderstudios2.skillsList,
                            imageRes = companyWonderstudios2.imageRes,
                        )
                        ExpandableCardExperience(
                            header = companyWonderstudios1.name,
                            subtitle = companyWonderstudios1.role,
                            date = companyWonderstudios1.period,
                            description = companyWonderstudios1.missionList,
                            skills = companyWonderstudios1.skillsList,
                            imageRes = companyWonderstudios1.imageRes,
                        )
                    }

                }
            }
        )

    }
}