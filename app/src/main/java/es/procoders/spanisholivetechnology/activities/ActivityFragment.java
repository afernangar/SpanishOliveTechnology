package es.procoders.spanisholivetechnology.activities;

import android.os.Bundle;
import android.widget.ImageButton;

import es.procoders.spanisholivetechnology.R;
import es.procoders.spanisholivetechnology.controllers.GeneralSingleton;
import es.procoders.spanisholivetechnology.fragments.FragmentMain;

/**
 * @author Procoders
 * @since API 21
 * @version 1.0
 */

/*Esta actividad llama a los fragments master/details que leen y modifican los formularios.
* Con nuestro singleton guardamos el fragmentManager que nos hará falta para movernos entre fragmentos.*/
public class ActivityFragment extends android.support.v4.app.FragmentActivity {

    private GeneralSingleton single;
    private ImageButton save, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biomasa);
        single = GeneralSingleton.getInstance();
        single.setFragmentManager(getSupportFragmentManager());

        save = (ImageButton) findViewById(R.id.btnOptionSave);
        back = (ImageButton) findViewById(R.id.btnBack);


        FragmentMain fragment = new FragmentMain();
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_activityBiomasa, fragment);
        ft.commit();


    }

}
