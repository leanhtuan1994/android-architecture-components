package com.zkuzan.basicrxjavasample

import android.content.Context
import com.zkuzan.basicrxjavasample.presistence.UserDAO
import com.zkuzan.basicrxjavasample.presistence.UserDatabase
import com.zkuzan.basicrxjavasample.ui.ViewModelFactory

object Injection {
    fun provideUserDataSource(context: Context): UserDAO {
        val database = UserDatabase.getInstance(context)
        return database.userDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val database = provideUserDataSource(context)
        return ViewModelFactory(database)
    }

}