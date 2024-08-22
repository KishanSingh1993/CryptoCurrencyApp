package com.kishan.cryptocurrency.domain.use_case.get_coin

import com.kishan.cryptocurrency.common.Resource
import com.kishan.cryptocurrency.domain.model.CoinDetails
import com.kishan.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
      suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> {
        return repository.getCoinById(coinId)
    }

}

