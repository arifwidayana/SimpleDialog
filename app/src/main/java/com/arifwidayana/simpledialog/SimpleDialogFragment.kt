package com.arifwidayana.simpledialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.arifwidayana.simpledialog.databinding.FragmentSimpleDialogBinding

class SimpleDialogFragment(private var name: String) : DialogFragment() {
    private var bind : FragmentSimpleDialogBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentSimpleDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (name.isNotEmpty()) {
            binding.tvName.text = name
        }

        binding.btnClose.setOnClickListener{
            Toast.makeText(activity, "anda menutup", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }
    }
}