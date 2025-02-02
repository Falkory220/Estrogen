package dev.mayaqq.estrogen.datagen.recipes.estrogen;

import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import dev.mayaqq.estrogen.datagen.recipes.EstrogenRecipeFabricImpl;
import dev.mayaqq.estrogen.datagen.recipes.EstrogenRecipeForgeImpl;
import dev.mayaqq.estrogen.datagen.recipes.EstrogenRecipeInterface;
import dev.mayaqq.estrogen.registry.common.EstrogenFluids;
import dev.mayaqq.estrogen.registry.common.EstrogenRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.resources.ResourceLocation;

import static dev.mayaqq.estrogen.Estrogen.id;


public class EstrogenCentrifugingRecipes<T extends EstrogenRecipeInterface> extends ProcessingRecipeGen {

    private T t;
    GeneratedRecipe LIQUID_ESTROGEN = create(id("liquid_estrogen"), recipeBuilder -> recipeBuilder
            .require(EstrogenFluids.FILTRATED_HORSE_URINE.get(), t.getAmount(81))
            .output(EstrogenFluids.LIQUID_ESTROGEN.get(), t.getAmount(81)));

    public EstrogenCentrifugingRecipes(FabricDataOutput output, T t) {
        super(output);
        this.t = t;
    }

    public static EstrogenCentrifugingRecipes buildFabric(FabricDataOutput output) {
        return new EstrogenCentrifugingRecipes<>(output, new EstrogenRecipeFabricImpl());
    }

    public static EstrogenCentrifugingRecipes buildForge(FabricDataOutput output) {
        return new EstrogenCentrifugingRecipes<>(output, new EstrogenRecipeForgeImpl());
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return EstrogenRecipes.CENTRIFUGING;
    }

    @Override
    protected ResourceLocation getRecipeIdentifier(ResourceLocation identifier) {
        return t.getRecipeIdentifier(identifier);
    }

    @Override
    public String getName() {
        return t.getName(super.getName());
    }
}
