package com.example.jetshop.jetshop.presentation.ProductScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetshop.jetshop.presentation.ProductScreen.widgets.AppTopBar
import com.example.jetshop.jetshop.presentation.ProductScreen.widgets.LoadingDialog
import com.example.jetshop.jetshop.presentation.ProductScreen.widgets.ProductItem


@Composable
internal fun ProductScreen(
    viewModel: ProductViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductContent(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductContent(
    state:ProductViewState
){
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(title = "Products")
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ){
            items(state.products){product ->
                ProductItem(product = product)
            }
        }
    }
}