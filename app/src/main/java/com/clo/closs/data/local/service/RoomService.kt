package com.clo.closs.data.local.service

import com.clo.closs.data.local.dao.ProductDao
import com.clo.closs.data.local.dao.UserDao
import com.clo.closs.data.local.entities.ProductEntity
import com.clo.closs.data.local.entities.UserEntity
import com.clo.closs.data.sources.LocalDataSource
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomService @Inject constructor(
    private val userDao: UserDao,
    private val productDao: ProductDao
) : LocalDataSource {
    override suspend fun upsertUser(user: User) =
        userDao.upsertUser(user.toDatabase())

    override suspend fun deleteUser() = userDao.deleteUser()

    override fun getUser(): Flow<List<User>> = userDao.getUser().map { value: List<UserEntity> ->
        value.map { userEntity: UserEntity ->
            userEntity.toDomain()
        }
    }

    override suspend fun getUserSession(): Boolean? = userDao.getUserSession()

    override suspend fun upsertProduct(productList: List<Product>) =
        productDao.upsertProduct(productList.map { product: Product -> product.toDataBase() })

    override suspend fun deleteProduct() = productDao.deteleProduct()

    override suspend fun getProducts(): List<Product> =
        productDao.getProducts().map { productEntity: ProductEntity ->
            productEntity.toDomain()
        }

    override fun searchProducts(query: String): List<Product> =
        productDao.searchProduct(query).map { productEntity: ProductEntity ->
            productEntity.toDomain()
        }
}
