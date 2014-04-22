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
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;

/**
 *
 * @author ZippyBling
 */
public class BiomeGenTallWoods extends BiomeGenBase {

    public BiomeGenTallWoods(int id) {
        super(id);
        this.theBiomeDecorator.treesPerChunk = 1;

        
    }
    
     public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenHugeTrees(false, 10 + par1Random.nextInt(20), 3, 3) : new WorldGenTrees(false, 4 + par1Random.nextInt(7), 3, 3, true))));
    }

    
}
