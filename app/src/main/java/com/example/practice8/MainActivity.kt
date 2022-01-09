package com.example.practice8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(MainActivityViewModel::class.java)

        observeViewModel()


        val languages = resources.getStringArray(R.array.languages_array)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            languages
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        getSolution.setOnClickListener {
            if (sideA.text.toString().matches(Regex("\\d+")) &&
                sideB.text.toString().matches(Regex("\\d+")) &&
                sideC.text.toString().matches(Regex("\\d+"))) {
                when (spinner.selectedItemPosition) {
                    0 -> viewModel.str.value =
                        (4 * (sideA.text.toString().toInt() +
                                sideB.text.toString().toInt() + sideC.text.toString().toInt()))
                            .toString()
                    1 -> viewModel.str.value =
                        (2 * (sideA.text.toString().toInt() * sideB.text.toString().toInt() +
                                sideA.text.toString().toInt() * sideC.text.toString().toInt() +
                                sideB.text.toString().toInt() * sideC.text.toString().toInt()))
                            .toString()
                    2 -> viewModel.str.value =
                        (sideA.text.toString().toInt() *
                                sideB.text.toString().toInt() * sideC.text.toString().toInt())
                            .toString()
                }
            } else
                viewModel.str.value ="Ошибка ввода"
        }

    }
    fun observeViewModel() {
        viewModel.str.observe(this, Observer { solution.setText(it) }) }
}