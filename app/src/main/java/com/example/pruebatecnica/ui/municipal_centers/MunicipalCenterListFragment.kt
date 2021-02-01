package com.example.pruebatecnica.ui.municipal_centers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica.R
import com.example.pruebatecnica.data.connections.ApiHelper
import com.example.pruebatecnica.data.connections.RetrofitBuilder
import com.example.pruebatecnica.data.model.MunicipalCenter
import com.example.pruebatecnica.ui.base.ViewModelFactory
import com.example.pruebatecnica.ui.municipal_centers.adapter.MunicipalCentersAdapter
import kotlinx.android.synthetic.main.fragment_municipal_centers.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MunicipalCenterListFragment : Fragment() {

    private lateinit var viewModel: MunicipalCenterListViewModel
    private lateinit var adapterInfo: MunicipalCentersAdapter
    private lateinit var adapterCleanPoint: MunicipalCentersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_municipal_centers, container, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupUI()
        setupObservers()
        getData()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MunicipalCenterListViewModel::class.java)
    }

    private fun setupUI() {
        municipalCenterRv?.layoutManager = LinearLayoutManager(context)
        adapterCleanPoint = MunicipalCentersAdapter(arrayListOf())
        municipalCenterRv.adapter = adapterCleanPoint

        infoCenterRv?.layoutManager = LinearLayoutManager(context)
        adapterInfo = MunicipalCentersAdapter(arrayListOf())
        infoCenterRv.adapter = adapterInfo
    }

    private fun getData() {
        viewModel.initData()
    }


    private fun setupObservers() {
        viewModel.cleanPointCenters.observe(viewLifecycleOwner, { parentCenter ->
            municipalCenterRv.visibility = View.VISIBLE
            parentCenter?.let { p ->
                cleanPointHeader.visibility = View.VISIBLE
                val municipalCenters: List<MunicipalCenter>? = p.centers
                municipalCenters?.let { it1 -> retrievePointList(it1) }
            }
        })

        viewModel.infoCenters.observe(viewLifecycleOwner, { parentCenter ->
            municipalCenterRv.visibility = View.VISIBLE
            parentCenter?.let { p ->
                infoHeader.visibility = View.VISIBLE
                val municipalCenters: List<MunicipalCenter>? = p.centers
                municipalCenters?.let { it1 -> retrieveInfoList(it1) }
            }
        })
    }

    private fun retrieveInfoList(municipalCenters: List<MunicipalCenter>) {
        adapterInfo.apply {
            addMunicipalCenter(municipalCenters)
            notifyDataSetChanged()
        }
    }

    private fun retrievePointList(municipalCenters: List<MunicipalCenter>) {
        adapterCleanPoint.apply {
            addMunicipalCenter(municipalCenters)
            notifyDataSetChanged()
        }
    }
}