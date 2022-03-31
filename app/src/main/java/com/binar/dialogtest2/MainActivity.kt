package com.binar.dialogtest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.binar.dialogtest2.databinding.ActivityMainBinding
import com.binar.dialogtest2.databinding.CustomLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var dialogBinding: CustomLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            basedDialog()
        }
        binding.button2.setOnClickListener{
            plusmin()
        }
        binding.customButton.setOnClickListener{
            custom()
        }
        binding.fragmentLayoutDialog.setOnClickListener{
            fragment()
        }
    }

    private fun basedDialog(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("judul pesan")
        dialog.setMessage("ini isi pesan")
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun plusmin(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Dengan Button")
        dialog.setMessage("Dialog Dengan Button untuk berbagai Aksi")
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setCancelable(false)
        dialog.setPositiveButton("Positive Button"){dialogInterface, p1 ->
            Toast.makeText(this,"Positive Button Clicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNegativeButton("Negative Button"){dialogInterface, p1->
            Toast.makeText(this,"Negative Button Clicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNeutralButton("Neutral Button"){dialogInterface, p1->
            Toast.makeText(this,"Neutral Button Clicked", Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }

    private fun custom(){
        dialogBinding = CustomLayoutBinding.inflate(layoutInflater)
        val dialogBuilder =AlertDialog.Builder(this)
        dialogBuilder.setView(dialogBinding.root)
        val dialog =dialogBuilder.create()

        dialogBinding.button3.setOnClickListener{
            Toast.makeText(this, "You cant Sign", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun fragment(){
        val alertDialog = FragmentDialog()
        alertDialog.show(supportFragmentManager,"fragment")
    }
}