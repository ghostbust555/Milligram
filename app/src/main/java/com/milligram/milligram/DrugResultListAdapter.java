package com.milligram.milligram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class DrugResultListAdapter extends ArrayAdapter<DrugResult> {

    ViewHolder viewHolder;

    private static class ViewHolder {
        private TextView drugNameTextView;
        private TextView qtyTextView;
        private TextView priceTextView;
        private TextView pharmacyTextView;
    }

    public DrugResultListAdapter(Context context, int textViewResourceId, List<DrugResult> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.results_list_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.drugNameTextView = (TextView) convertView.findViewById(R.id.drugNameTextView);
            viewHolder.qtyTextView = (TextView) convertView.findViewById(R.id.qtyTextView);
            viewHolder.priceTextView = (TextView) convertView.findViewById(R.id.priceTextView);
            viewHolder.pharmacyTextView = (TextView) convertView.findViewById(R.id.pharmacyTextView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DrugResult item = getItem(position);
        if (item!= null) {
            // My layout has only one TextView
            // do whatever you want with your string and long
            Currency currentCurrency = Currency.getInstance(Locale.getDefault());
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

            viewHolder.drugNameTextView.setText(item.ln);
            viewHolder.pharmacyTextView.setText(item.pharmacy_name);
            viewHolder.priceTextView.setText(currencyFormatter.format(item.price));
            viewHolder.qtyTextView.setText("qty:"+item.qty);
        }

        return convertView;
    }
}