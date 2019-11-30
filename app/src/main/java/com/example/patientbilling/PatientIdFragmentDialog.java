package com.example.patientbilling;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PatientIdFragmentDialog extends DialogFragment {

    public static interface OnCompleteListener {
        public abstract void onComplete(String time);
    }

    private OnCompleteListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = requireActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.patient_id_dialog, null);

        builder.setView(dialogView)
                .setPositiveButton(R.string.layout_submit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editTextPatientID = (EditText) dialogView.findViewById(R.id.patient_id);
                        String patientID = editTextPatientID.getText().toString();
                        sendDataBack(patientID);
                    }
                })
        .setNegativeButton(R.string.layout_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PatientIdFragmentDialog.this.getDialog().cancel();
            }
        });

        return builder.create();
    }

    public void sendDataBack(String patientID) {
        this.mListener.onComplete(patientID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            this.mListener = (OnCompleteListener) context;
        }
        catch (Exception e) {
            throw new ClassCastException(context.toString() + " must implement OnCompleteListener");
        }
    }
}
