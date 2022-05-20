package com.gregoirebonnier.cvplayerone.ui.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gregoirebonnier.cvplayerone.ui.tools.ExpandableCard

class ExperienceScreen() {

    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
        ) {
            ExpandableCard(
                header = "Optimetriks",
                subtitle = "Android Developer",
                date = "2020-2022",
                description = optimetriksDescription,
                skills = optimetriksSkills,
            )
            ExpandableCard(
                header = "Wonderstudios 2/2",
                subtitle = "Account Manager",
                date = "2020-2022",
                description = optimetriksDescription,
                skills = listOf("lsdlds", "sdsdzd", "sdsdsd")
            )
            ExpandableCard(
                header = "Wonderstudios 1/2",
                subtitle = "Web Developer",
                date = "2020-2022",
                description = optimetriksDescription,
                skills = listOf("lsdlds", "sdsdzd", "sdsdsd")
            )
        }
    }

    private val optimetriksSkills = listOf(
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
        "Espresso",
        "Room",
        "Retrofit",
        "Koin Injection",
        "Koin Test",
        "Git",
        "Agility Management",
        "Jira",
    )

    private val optimetriksDescription = listOf(
        "Contributing to the modularisation of the Android application",
        "Improving application quality",
        "Facilitating meetings in accordance with SrumBan agility",
        "Participating in the design phase",
        "Writing the technical specifications",
    )
}