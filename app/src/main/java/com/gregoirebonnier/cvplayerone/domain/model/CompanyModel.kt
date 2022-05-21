package com.gregoirebonnier.cvplayerone.domain.model

class CompanyModel(
    /**
     *
     */
    val name: String,
    /**
     *
     */
    val role: String,
    /**
     *
     */
    val period: String,
    /**
     *
     */
    val missionList: List<String>,
    /**
     *
     */
    val skillsList: List<String>,
    /**
     *
     */
    val imageRes: Int,
)