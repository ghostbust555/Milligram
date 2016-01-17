package com.milligram.milligram;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };

    DrugResultList dl = GetDrugResults();

    DrugResultList GetDrugResults(){
        String json = "{\n" +
                "   \"located_drugs\":[\n" +
                "      {\n" +
                "         \"awp_price\":\"12.0700\",\n" +
                "         \"address\":\"1628 Chestnut St # 36\",\n" +
                "         \"brand_generic\":\"G  \",\n" +
                "         \"chain_code\":\"181\",\n" +
                "         \"city\":\"Philadelphia\",\n" +
                "         \"distance\":\"0.23\",\n" +
                "         \"drug_ranking\":\"1\",\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"group_name\":\"MILLIGRAM\",\n" +
                "         \"group_num\":\"1338\",\n" +
                "         \"hours_of_operation\":\"S(8a-8p) M(7a-10p) T(7a-10p) W(7a-10p) T(7a-10p) F(7a-10p) S(8a-10p)\",\n" +
                "         \"ln\":\"AMOXICILLIN 500 MG CAPSULE\",\n" +
                "         \"latitude\":\"39.951331\",\n" +
                "         \"longitude\":\"-75.168005\",\n" +
                "         \"mac_price\":null,\n" +
                "         \"ncpdp\":\"3939913\",\n" +
                "         \"ndc\":\"00781261305\",\n" +
                "         \"pharmacy_name\":\"RITE AID PHARMACY\",\n" +
                "         \"phone\":\"(215)972-0234\",\n" +
                "         \"price\":\"12.0700\",\n" +
                "         \"price_basis\":\"AWP\",\n" +
                "         \"qty\":\"30\",\n" +
                "         \"quantity_ranking\":\"1\",\n" +
                "         \"state\":\"PA\",\n" +
                "         \"uc_price\":\"9999999.0000\",\n" +
                "         \"zip\":\"19103-5119\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"awp_price\":\"13.0500\",\n" +
                "         \"address\":\"113 S 18th St\",\n" +
                "         \"brand_generic\":\"G  \",\n" +
                "         \"chain_code\":\"000\",\n" +
                "         \"city\":\"Philadelphia\",\n" +
                "         \"distance\":\"0.11\",\n" +
                "         \"drug_ranking\":\"1\",\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"group_name\":\"MILLIGRAM\",\n" +
                "         \"group_num\":\"1338\",\n" +
                "         \"hours_of_operation\":\"S(Clsd) M(9a-6p) T(9a-6p) W(9a-6p) T(9a-6p) F(9a-6p) S(10a-2p)\",\n" +
                "         \"ln\":\"AMOXICILLIN 500 MG CAPSULE\",\n" +
                "         \"latitude\":\"39.951341\",\n" +
                "         \"longitude\":\"-75.17036\",\n" +
                "         \"mac_price\":null,\n" +
                "         \"ncpdp\":\"3990745\",\n" +
                "         \"ndc\":\"00781261305\",\n" +
                "         \"pharmacy_name\":\"18TH STREET APOTHECARY\",\n" +
                "         \"phone\":\"(215)564-0900\",\n" +
                "         \"price\":\"13.0500\",\n" +
                "         \"price_basis\":\"AWP\",\n" +
                "         \"qty\":\"30\",\n" +
                "         \"quantity_ranking\":\"1\",\n" +
                "         \"state\":\"PA\",\n" +
                "         \"uc_price\":\"9999999.0000\",\n" +
                "         \"zip\":\"19103-5117\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"awp_price\":\"13.0600\",\n" +
                "         \"address\":\"1700 Market St\",\n" +
                "         \"brand_generic\":\"G  \",\n" +
                "         \"chain_code\":\"455\",\n" +
                "         \"city\":\"Philadelphia\",\n" +
                "         \"distance\":\"0.22\",\n" +
                "         \"drug_ranking\":\"1\",\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"group_name\":\"MILLIGRAM\",\n" +
                "         \"group_num\":\"1338\",\n" +
                "         \"hours_of_operation\":\"S(Clsd) M(8a-6p) T(8a-6p) W(8a-6p) T(8a-6p) F(8a-6p) S(7p-2p)\",\n" +
                "         \"ln\":\"AMOXICILLIN 500 MG CAPSULE\",\n" +
                "         \"latitude\":\"39.952981\",\n" +
                "         \"longitude\":\"-75.168431\",\n" +
                "         \"mac_price\":null,\n" +
                "         \"ncpdp\":\"3985059\",\n" +
                "         \"ndc\":\"65862001705\",\n" +
                "         \"pharmacy_name\":\"PICKWICK PHARMACY INC\",\n" +
                "         \"phone\":\"(215)563-4860\",\n" +
                "         \"price\":\"13.0600\",\n" +
                "         \"price_basis\":\"AWP\",\n" +
                "         \"qty\":\"30\",\n" +
                "         \"quantity_ranking\":\"1\",\n" +
                "         \"state\":\"PA\",\n" +
                "         \"uc_price\":\"9999999.0000\",\n" +
                "         \"zip\":\"19103-3913\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"awp_price\":\"15.5000\",\n" +
                "         \"address\":\"1826 Chestnut St # 30\",\n" +
                "         \"brand_generic\":\"G  \",\n" +
                "         \"chain_code\":\"039\",\n" +
                "         \"city\":\"Philadelphia\",\n" +
                "         \"distance\":\"0.06\",\n" +
                "         \"drug_ranking\":\"1\",\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"group_name\":\"MILLIGRAM\",\n" +
                "         \"group_num\":\"1338\",\n" +
                "         \"hours_of_operation\":\"Open 24 Hours\",\n" +
                "         \"ln\":\"AMOXICILLIN 500 MG CAPSULE\",\n" +
                "         \"latitude\":\"39.951747\",\n" +
                "         \"longitude\":\"-75.171154\",\n" +
                "         \"mac_price\":null,\n" +
                "         \"ncpdp\":\"3969485\",\n" +
                "         \"ndc\":\"65862001705\",\n" +
                "         \"pharmacy_name\":\"CVS PHARMACY\",\n" +
                "         \"phone\":\"(215)972-0909\",\n" +
                "         \"price\":\"15.5000\",\n" +
                "         \"price_basis\":\"AWP\",\n" +
                "         \"qty\":\"30\",\n" +
                "         \"quantity_ranking\":\"1\",\n" +
                "         \"state\":\"PA\",\n" +
                "         \"uc_price\":\"9999999.0000\",\n" +
                "         \"zip\":\"19103-4902\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"awp_price\":\"19.4500\",\n" +
                "         \"address\":\"17 S 20th St\",\n" +
                "         \"brand_generic\":\"G  \",\n" +
                "         \"chain_code\":\"630\",\n" +
                "         \"city\":\"Philadelphia\",\n" +
                "         \"distance\":\"0.09\",\n" +
                "         \"drug_ranking\":\"1\",\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"group_name\":\"MILLIGRAM\",\n" +
                "         \"group_num\":\"1338\",\n" +
                "         \"hours_of_operation\":\"S(Clsd) M(8a-5p) T(8a-5p) W(8a-5p) T(8a-5p) F(8a-5p) S(8a-12p)\",\n" +
                "         \"ln\":\"AMOXICILLIN 500 MG CAPSULE\",\n" +
                "         \"latitude\":\"39.953041\",\n" +
                "         \"longitude\":\"-75.173258\",\n" +
                "         \"mac_price\":null,\n" +
                "         \"ncpdp\":\"3910115\",\n" +
                "         \"ndc\":\"16714029904\",\n" +
                "         \"pharmacy_name\":\"DOCTORS PHARMACY INC\",\n" +
                "         \"phone\":\"(215)567-6870\",\n" +
                "         \"price\":\"19.4500\",\n" +
                "         \"price_basis\":\"AWP\",\n" +
                "         \"qty\":\"30\",\n" +
                "         \"quantity_ranking\":\"1\",\n" +
                "         \"state\":\"PA\",\n" +
                "         \"uc_price\":\"9999999.0000\",\n" +
                "         \"zip\":\"19103-3528\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"gsn\":\"008996\",\n" +
                "   \"ndc\":\"00781261305\",\n" +
                "   \"description\":\"AMOXICILLIN 500 MG CAPSULE\",\n" +
                "   \"forms\":[\n" +
                "      {\n" +
                "         \"form\":\"Capsule\",\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"is_selected\":true,\n" +
                "         \"ranking\":\"1\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"form\":\"Tablet\",\n" +
                "         \"gsn\":\"040292\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"ranking\":\"2\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"form\":\"Oral Suspension\",\n" +
                "         \"gsn\":\"042683\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"ranking\":\"3\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"form\":\"Chewable Tablet\",\n" +
                "         \"gsn\":\"009001\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"ranking\":\"4\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"quantities\":[\n" +
                "      {\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"is_selected\":true,\n" +
                "         \"quantity\":\"30\",\n" +
                "         \"quantity_label\":\"capsules\",\n" +
                "         \"ranking\":\"1\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"quantity\":\"21\",\n" +
                "         \"quantity_label\":\"capsules\",\n" +
                "         \"ranking\":\"2\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"quantity\":\"28\",\n" +
                "         \"quantity_label\":\"capsules\",\n" +
                "         \"ranking\":\"3\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"quantity\":\"20\",\n" +
                "         \"quantity_label\":\"capsules\",\n" +
                "         \"ranking\":\"4\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"quantity\":\"40\",\n" +
                "         \"quantity_label\":\"capsules\",\n" +
                "         \"ranking\":\"5\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"strengths\":[\n" +
                "      {\n" +
                "         \"gsn\":\"008996\",\n" +
                "         \"is_selected\":true,\n" +
                "         \"ranking\":\"0\",\n" +
                "         \"strength\":\"500 MG\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"gsn\":\"008995\",\n" +
                "         \"is_selected\":false,\n" +
                "         \"ranking\":\"0\",\n" +
                "         \"strength\":\"250 MG\"\n" +
                "      }\n" +
                "   ]\n" +
                "}\n";

        return DrugResultList.fromJson(json);
    }

    public void backPressed(View v){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView resultsView = (ListView) findViewById(R.id.resultsView);
        resultsView.setAdapter(new DrugResultListAdapter(this, R.layout.results_list_layout, dl.located_drugs));

        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_back);

        System.out.print("");
    }
}
