package com.kishan.cryptocurrency.domain.repository

import com.kishan.cryptocurrency.common.Resource
import com.kishan.cryptocurrency.domain.model.Coin
import com.kishan.cryptocurrency.domain.model.CoinDetails
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(fetchFromRemote: Boolean, query: String): Flow<Resource<List<Coin>>>

    suspend fun getCoinById(coinId:String): Flow<Resource<CoinDetails>>

}