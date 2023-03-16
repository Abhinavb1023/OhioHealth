package com.ohiohealth.kata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ohiohealth.kata.databinding.CommonLayoutBinding
import java.util.*

class FirstPage : AppCompatActivity() {

    private lateinit var mBinding: CommonLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = CommonLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.title = getString(R.string.FIRST_PAGE)
        mBinding.btnAction.text = getString(R.string.btn_next)

        mBinding.etFirstName.requestFocus()

        mBinding.btnAction.setOnClickListener {
            validate()
        }
    }

    private fun validate(): Boolean {
        var isValid = true

        if (mBinding.etYearOfJoining.length() < 4 ||
            mBinding.etYearOfJoining.text.toString().toInt() >
            Calendar.getInstance().get(Calendar.YEAR)
        ) {
            mBinding.etYearOfJoining.error = "Enter valid year of joining"
            mBinding.etYearOfJoining.requestFocus()
            isValid = false
        }

        if (mBinding.etCityName.length() <= 0) {
            mBinding.etCityName.error = "Enter city name"
            mBinding.etCityName.requestFocus()
            isValid = false
        }

        if (mBinding.etFirstName.length() <= 0) {
            mBinding.etFirstName.error = "Enter first name"
            mBinding.etFirstName.requestFocus()
            isValid = false
        }

        return isValid
    }
}