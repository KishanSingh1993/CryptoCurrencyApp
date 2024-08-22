package com.kishan.cryptocurrency.presentation.coin_list

import com.kishan.cryptocurrency.domain.model.Coin


data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
