package com.example.melichallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.melichallenge.R
import com.example.melichallenge.databinding.ActivityMainBinding
import com.example.melichallenge.model.Item
import com.example.melichallenge.viewmodel.MeliViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

/*   val listaParaTestear = listOf (    //  LISTA DE ITEMS PARA TESTEAR EL RECYCLERVIEW Y LA CONECTIVIDAD

        Item (29599, "http://http2.mlstatic.com/D_823471-MLA46361763249_062021-O.jpg", "Moto G20"),
        Item (21999, "http://http2.mlstatic.com/D_842056-MLA46651798889_072021-I.jpg", "Moto E7"),
        Item (34999, "http://http2.mlstatic.com/D_738903-MLA45683797219_042021-I.jpg", "Moto G30"),
        Item (35000, "http://http2.mlstatic.com/D_914266-MLA43921797208_102020-I.jpg", "Moto G9"),
        Item (19999, "http://http2.mlstatic.com/D_625423-MLA46125192173_052021-O.jpg", "Moto E7i"),
        Item (20999, "http://http2.mlstatic.com/D_906649-MLA43437746274_092020-I.jpg", "Moto E6s"),
        Item (17999, "http://http2.mlstatic.com/D_949194-MLA45093637921_032021-O.jpg", "Moto E6i"),
        Item (79999, "http://http2.mlstatic.com/D_893265-MLA46248823275_062021-I.jpg", "Moto G100"),
        Item (44408, "http://http2.mlstatic.com/D_981946-MLA43875413412_102020-I.jpg", "Moto G9 Plus"),
        Item (27999, "http://http2.mlstatic.com/D_834674-MLA46361641840_062021-O.jpg", "Moto G20")
    )

*/


    lateinit var binding: ActivityMainBinding

    private val meliViewModel : MeliViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //iniciarRecycler(listaParaTestear)  //  TESTEO utilizando la lista listaParaTestear


        meliViewModel.meliModel.observe(this, androidx.lifecycle.Observer {


            iniciarRecycler(it.results)  // INICIA EL RECYCLERVIEW CON LOS RESULTADOS DE LA BUSQUEDA

        })



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(inputTexto: String): Boolean {

                binding.searchView.clearFocus()

                meliViewModel.obtenerItems((inputTexto).lowercase(Locale.getDefault())) //  INICIA EL RECYCLER CON EL INPUT

                return false

            }

            override fun onQueryTextChange(inputTexto: String): Boolean {

                return false
            }

        })

    }

    private fun iniciarRecycler (lista : List<Item>) {  //  METODO PARA INICIAR EL RECYCLERVIEW CON UNA LISTA DE ITEMS

        val adapter = MainAdapter(lista)

        val recyclerView = findViewById<RecyclerView>(R.id.rvListadoItems)

        recyclerView?.layoutManager =
            StaggeredGridLayoutManager(
                1,
                StaggeredGridLayoutManager.VERTICAL
            )

        recyclerView?.adapter = adapter

    }


}


