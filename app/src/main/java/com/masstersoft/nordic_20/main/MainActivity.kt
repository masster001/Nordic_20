package com.masstersoft.nordic_20.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.masstersoft.nordic_20.R

class MainActivity : AppCompatActivity(), NextFragmentInterface {

    /***
     * По нажатию на кнопку передавать в следующий фрагмент
     * количество элементов в бэкстэке
     *
     * И логировало инфу -
     * 0. Нажали кнопку перейти на фрагмент №...
     * 1. Фрагмент
     * 2. количество
     *
     * Важно! При нажатии на back логировать это в консоль
     *
     * Запускаемая активити - MainActivity
     * Добавить переход на вторую активити
     * Сделать во второй активити горизонтальную разметку
     *
     * Сделать минимальное количество интерфейсов
     * избавиться от getReceiverListener()
     * избавиться от getCountListener()
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, Fragment_1())
            .addToBackStack("frg")
            .commit()
    }

    override fun nextFragment(frg: Fragment) {
        if (frg is Fragment_1) {
            supportFragmentManager
                .popBackStack(
                    null,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, frg)
            .addToBackStack(frg.toString())
            .commit()

        printBackStack()
    }

    fun printBackStack(){
        println("Nordic_20 ${supportFragmentManager.backStackEntryCount}")
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount==1){
            finish()
        }else{
            super.onBackPressed()
        }
    }
}
