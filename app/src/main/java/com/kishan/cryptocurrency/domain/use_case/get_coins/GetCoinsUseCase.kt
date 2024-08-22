package com.kishan.cryptocurrency.domain.use_case.get_coins

import com.kishan.cryptocurrency.common.Resource
import com.kishan.cryptocurrency.domain.model.Coin
import com.kishan.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

     suspend operator fun invoke(fetchFromRemote: Boolean, query: String): Flow<Resource<List<Coin>>> {
        return repository.getCoins(fetchFromRemote,query)
    }

}