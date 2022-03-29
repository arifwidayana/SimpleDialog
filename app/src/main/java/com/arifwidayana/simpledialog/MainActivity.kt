package com.arifwidayana.simpledialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import com.arifwidayana.simpledialog.databinding.ActivityMainBinding
import com.arifwidayana.simpledialog.databinding.CustomDialogBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Toast.makeText(this, "Apa kabar", Toast.LENGTH_SHORT).show()
        }

        binding.button2.setOnClickListener {
            Snackbar.make(it, "mengkabar", Snackbar.LENGTH_LONG).show()
        }

        binding.button3.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setIcon(R.mipmap.ic_launcher_round)
                .setTitle("pokoe joget")
                .setMessage("sik asik")
                .setCancelable(false)

            dialog.setPositiveButton("Positif"){dialog,i ->
                Toast.makeText(this, "positif bro", Toast.LENGTH_SHORT).show()
            }

            dialog.setNegativeButton("Negatif"){dialog,i ->
                Toast.makeText(this, "negatif bro", Toast.LENGTH_SHORT).show()
            }

            dialog.setNeutralButton("Neutral"){dialog,i ->
                Toast.makeText(this, "neutral bro", Toast.LENGTH_SHORT).show()
            }

            dialog.show()
        }

        binding.btnCust.setOnClickListener {
            val bind = CustomDialogBinding.inflate(LayoutInflater.from(this))
            val dialogBuild = AlertDialog.Builder(this)
            dialogBuild.setView(bind.root)
            val dialog = dialogBuild.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            bind.btnCustom.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(this, "Custom Berhasil", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }

        binding.btnDialogFrag.setOnClickListener {
            val diFrag = SimpleDialogFragment(binding.etDialogFrag.text.toString())
            diFrag.show(supportFragmentManager, null)
        }
    }
}