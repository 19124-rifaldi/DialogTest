package com.binar.dialogtest2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.binar.dialogtest2.databinding.FragmentLayoutBinding

class FragmentDialog: DialogFragment() {
    private lateinit var binding :FragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLayoutBinding.bind(view)

        binding.button3.setOnClickListener{
            dialog?.dismiss()
            Toast.makeText(requireContext(),"cant Sign",Toast.LENGTH_LONG).show()
        }
    }
}