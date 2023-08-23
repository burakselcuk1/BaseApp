package com.basew.core

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.basew.common.extentions.getNavOptions
import com.basew.common.extentions.getNavigationResult
import com.basew.common.extentions.setCurrentNavigationResult
import com.basew.common.extentions.setNavigationResult


abstract class BaseNavigator : Navigation {
    lateinit var navController: NavController

    override fun bind(navController: NavController) {
        this.navController = navController
    }

    private fun getBundleByNavArgs(args: NavArgs): Bundle {
        val toBundleMethod = args::class.java.getMethod("toBundle")
        return toBundleMethod.invoke(args) as Bundle
    }
    fun navigate(@IdRes destinationId: Int, args: NavArgs? = null, navOptions: NavOptions? = null) {
        navController.navigate(destinationId, args?.let { getBundleByNavArgs(it) }, navOptions ?: navController.getNavOptions().build())
    }

    fun <T> getNavigationResult(key: String = "result") = navController.getNavigationResult<T>(key)

    fun <T> setNavigationResult(result: T, key: String = "result") { navController.setNavigationResult<T>(result, key) }

    fun <T> setCurrentNavigationResult(result: T, key: String = "result") { navController.setCurrentNavigationResult(result, key) }

    fun <T> setNavigationResult(result: T, key: String = "result", destinationId: Int) {
        navController.setNavigationResult(result, key, destinationId)
    }

}

