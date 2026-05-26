package br.com.gestaocriativos;

import br.com.gestaocriativos.domain.CreativeType;
import br.com.gestaocriativos.evaluation.CreativeEvaluator;
import br.com.gestaocriativos.evaluation.CreativeEvaluatorFactory;
import br.com.gestaocriativos.evaluation.ImageCreativeEvaluator;
import br.com.gestaocriativos.evaluation.TextCreativeEvaluator;
import br.com.gestaocriativos.evaluation.VideoCreativeEvaluator;

public class CreativeEvaluatorFactoryTest {
    public void deveCriarAvaliadorDeVideo() {
        CreativeEvaluator evaluator = new CreativeEvaluatorFactory().create(CreativeType.VIDEO);
        Assertions.assertTrue(evaluator instanceof VideoCreativeEvaluator, "Deveria criar avaliador de vídeo");
    }

    public void deveCriarAvaliadorDeImagem() {
        CreativeEvaluator evaluator = new CreativeEvaluatorFactory().create(CreativeType.IMAGE);
        Assertions.assertTrue(evaluator instanceof ImageCreativeEvaluator, "Deveria criar avaliador de imagem");
    }

    public void deveCriarAvaliadorDeTexto() {
        CreativeEvaluator evaluator = new CreativeEvaluatorFactory().create(CreativeType.TEXT);
        Assertions.assertTrue(evaluator instanceof TextCreativeEvaluator, "Deveria criar avaliador de texto");
    }
}
