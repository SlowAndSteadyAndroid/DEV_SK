package com.example.samplemvvm.ui.home.a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.samplemvvm.databinding.FragmentABinding
import com.example.samplemvvm.ui.home.HomeViewModel
import com.example.samplemvvm.ui.home.adapter.PersonAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AFragment : Fragment() {

    private val binding: FragmentABinding by lazy {
        FragmentABinding.inflate(layoutInflater)
    }

    private val homeSharedViewModel by sharedViewModel<HomeViewModel>()

    private val personAdapter by lazy { PersonAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeSharedViewModel.viewStateLiveData.observe(requireActivity()) {viewState ->
            when(viewState){
                is HomeViewModel.HomeViewState.GetPersonData -> {
                    personAdapter.addAll(viewState.personData)
                }
            }
        }

        binding.rvPerson.run {
            adapter = personAdapter
        }

    }


    companion object {
        fun newInstance() =
            AFragment()
    }
}