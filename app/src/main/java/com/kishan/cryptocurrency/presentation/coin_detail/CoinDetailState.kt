package com.kishan.cryptocurrency.presentation.coin_detail

import com.kishan.cryptocurrency.domain.model.CoinDetails


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = "",
    val isRefreshing: Boolean = false

)
