package com.ohiohealth.kata

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.gson.Gson
import com.ohiohealth.kata.data.User
import com.ohiohealth.kata.databinding.CommonLayoutBinding
import com.ohiohealth.kata.util.SharedPreferenceManager
import java.util.*

class SecondPage : AppCompatActivity() {

    lateinit var mBinding: CommonLayoutBinding
    lateinit var mTextToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = CommonLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.title = getString(R.string.SECOND_PAGE)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mBinding.btnAction.text = getString(R.string.btn_retrieve)

        mTextToSpeech = TextToSpeech(this) {
            if (it != TextToSpeech.ERROR) {
                mTextToSpeech.language = Locale.US
            }
        }

        mBinding.btnAction.setOnClickListener {
            val sharedPreferenceManager = SharedPreferenceManager(this)
            val userData = sharedPreferenceManager.getString(SharedPreferenceManager.USER_DATA)
            mBinding.user = Gson().fromJson(userData, User::class.java)

            mBinding.btnTranslate.isVisible = true
        }

        mBinding.btnTranslate.setOnClickListener {
            mTextToSpeech.speak(
                mBinding.etCityName.text.toString(), TextToSpeech.QUEUE_FLUSH, null, null
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }
}