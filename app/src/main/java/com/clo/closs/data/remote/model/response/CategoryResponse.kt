package com.clo.closs.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @field:SerializedName("CategoryResponse")
    val categories: List<CategoryResponseItem?>? = null
)

data class CategoryResponseItem(
    @field:SerializedName("categoryImage")
    val categoryImage: String? = null,

    @field:SerializedName("name")
    val name: String? = null
)
