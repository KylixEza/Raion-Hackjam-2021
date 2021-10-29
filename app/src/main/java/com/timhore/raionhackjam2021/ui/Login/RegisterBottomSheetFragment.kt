package com.timhore.raionhackjam2021.ui.Login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.databinding.FragmentRegisterbottomsheetBinding
import com.timhore.raionhackjam2021.ui.BaseActivity

class RegisterBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentRegisterbottomsheetBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterbottomsheetBinding.inflate(inflater, container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnDaftar?.setOnClickListener{
            activity?.let{
                val intent = Intent (it, BaseActivity::class.java)
                it.startActivity(intent)
            }
        }

    }

}