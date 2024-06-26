package com.project.screenmatch.Controllers;

import com.project.screenmatch.dtos.EpisodioDto;
import com.project.screenmatch.dtos.SerieDto;
import com.project.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {

    @Autowired
    SerieService serieService;

    @GetMapping("/series")
   public List<SerieDto> getSeries(){
        return serieService.listarSeries();
    }

    @GetMapping("/series/top5")
    public List<SerieDto> getTop5Series() {
        return serieService.top5Series();
    }

    @GetMapping("/series/lancamentos")
    public List<SerieDto> getSeriesLancamentos(){return serieService.seriesLancamentos();}

    @GetMapping ("/series/nome/{nomeSerie}")
    public SerieDto getserieBuscada(@PathVariable String nomeSerie){
        return  serieService.buscarSerie(nomeSerie);
    }

    @GetMapping("/series/{id}")
    public SerieDto getSerieById(@PathVariable Long id) {
        return serieService.buscarSeriePorId(id);
    }

    @GetMapping("/series/{id}/temporadas/todas")
    public List<EpisodioDto> TemporadasDaSerie(@PathVariable Long id){
        return serieService.buscarTodosEpisodiosDaSerie(id);
    }

    @GetMapping("/series/{id}/temporadas/{temporada}")
    public List<EpisodioDto> episodiosPorTemporada(@PathVariable Long id, @PathVariable Integer temporada){
        return serieService.buscarEpisodiosPorTemporada(id,temporada);
    }

    @GetMapping("series/categoria/{categoria}")
    public List<SerieDto> seriesPorCategoria(@PathVariable String categoria){
        return serieService.buscarSeriePorCategoria(categoria);
    }

}
