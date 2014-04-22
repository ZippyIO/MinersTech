/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech.biomes;

import MinersTech.MinersTech;
import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import MinersTech.trees.BigWoodsTree;
import MinersTech.Misc.worldGeneratorBigWoods;

/**
 *
 * @author ZippyBling
 */
public class BiomeGenBigWoods extends BiomeGenBase {

    public BiomeGenBigWoods(int id) {
        super(id);
        this.theBiomeDecorator.treesPerChunk = 6;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.sandGen.equals(12);

        
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(5) == 0 ? this.worldGeneratorBigTree : (par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree: this.worldGeneratorBigTree));
    }
    
}
