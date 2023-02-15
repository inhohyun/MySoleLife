package com.shoppi.shoppi.mysolelife.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.shoppi.shoppi.mysolelife.R
import com.shoppi.shoppi.mysolelife.contentsList.ContentsListActivity
import com.shoppi.shoppi.mysolelife.databinding.FragmentTipBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [TipFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TipFragment : Fragment() {
    private lateinit var binding: FragmentTipBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tip, container, false)

        binding.category1.setOnClickListener{
            val intent = Intent(context, ContentsListActivity::class.java)
            startActivity(intent)
        }

        binding.homeTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_homeFragment)
        }
        binding.talkTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_talkFragment)

        }
        binding.bookmarkTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_bookmarkFragment)

        }
        binding.storeTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_tipFragment_to_storeFragment)

        }

        return binding.root
    }


}