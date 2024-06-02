package com.example.proyectopdm2024_gt2_grupo1_tema

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog


class MultipleChoiceDialogFragment : DialogFragment() {

    //Alert Dialog con CheckBox para la vista de Seleccionar Días de Recordatorio------------------------------------
    interface OnMultiChoiceListener {
        fun onPositiveButtonClicked(list: Array<String>, selectedItemList: ArrayList<String>)
        fun onNegativeButtonClicked()
    }

    private var mListener: OnMultiChoiceListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = try {
            context as OnMultiChoiceListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnMultiChoiceListener")
        }
    }

    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val selectedItemList = ArrayList<String>()
        val list = activity?.resources?.getStringArray(R.array.elegir_dias) ?: arrayOf()

        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Select Your Choice")
            .setMultiChoiceItems(list, null) { _, which, isChecked ->
                if (isChecked) {
                    selectedItemList.add(list[which])
                } else {
                    selectedItemList.remove(list[which])
                }
            }
            .setPositiveButton("Ok") { _, _ ->
                mListener?.onPositiveButtonClicked(list, selectedItemList)
            }
            .setNegativeButton("Cancel") { _, _ ->
                mListener?.onNegativeButtonClicked()
            }

        return builder.create()
    }
}