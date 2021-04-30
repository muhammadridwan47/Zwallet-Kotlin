package com.example.zwallet.ui.auth.signin

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.zwallet.R
import com.example.zwallet.Zwallet
import com.example.zwallet.model.response.login.Token
import com.example.zwallet.ui.MainActivity
import com.example.zwallet.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_signin.*

class SigninFragment : Fragment(), SignContract.View {

    lateinit var presenter: SigninPresenter

    var progressDialog : Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = SigninPresenter(this)


        goSignup.setOnClickListener {
            val goSignin = Intent(activity,AuthActivity::class.java)
            goSignin.putExtra("goSignup",2)
            startActivity(goSignin)
        }

        initDummyLogin() // dummy data
        initView() // laoder load

        btnLogin.setOnClickListener {
            var email  = fieldEmail.text.toString()
            var password  = fieldPassword.text.toString()

            if (email.isNullOrEmpty()) {
                fieldEmail.error = "Please input your email...!"
                fieldPassword.requestFocus()
            } else if (password.isNullOrEmpty()) {
                fieldEmail.error = "Please input your password...!"
                fieldPassword.requestFocus()
            } else {
                presenter.submitLogin(email,password)
            }
        }



    }


    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader,null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    private fun initDummyLogin() {
        fieldEmail.setText("handi@gmail.com")
        fieldPassword.setText("12345678")
    }

    override fun onLoginSuccess(loginResponse: Token) {
        Zwallet.getApp().setToken(loginResponse.token)
        startActivity(Intent(activity, MainActivity::class.java))
        activity?.finish()
    }

    override fun onLoginFailed(message: String) {
        Toast.makeText(activity,"Login Failed please try again",Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }

}