package com.vipulasri.jetinstagram

import android.app.Application
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import com.google.android.exoplayer2.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class MainViewModel(application: Application):AndroidViewModel(application) {
    private lateinit var firebaseFirestore: FirebaseFirestore

    private lateinit var storageRef: StorageReference
    private var imageUri: Uri? = null

    private fun initVars() {
        storageRef = FirebaseStorage.getInstance().reference.child("Images")
        firebaseFirestore = FirebaseFirestore.getInstance()
    }
    fun  uploadImage() {
        val context = LocalContext

        storageRef = storageRef.child(System.currentTimeMillis().toString())
        imageUri?.let {
            storageRef.putFile(it).addOnCompleteListener{task->
                if (task.isSuccessful){
                    storageRef.downloadUrl.addOnSuccessListener { uri ->

                        val map = HashMap<String, Any>()
                        map["pic"] = uri.toString()

                        firebaseFirestore.collection("images").add(map).addOnCompleteListener{ firestoreTask ->

                            if (firestoreTask.isSuccessful){
                                Log.d("Check", "firestoreTask.isSuccessful")
                            }else{
                                Log.d("Check", "firestoreTask.Error")
                             }
                        }
                    }
                }else{
                    Log.d("Check", "task.Error")

                }
            }
        }
    }
}