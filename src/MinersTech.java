/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinersTech;

import MinersTech.Machines.BlockMacerator;
import MinersTech.Blocks.CommieniteBlock;
import MinersTech.Blocks.MachineCasing;
import MinersTech.Blocks.MinersFurnace;
import MinersTech.Blocks.OreGrinder;
import MinersTech.Blocks.ZianiteBlock;
import MinersTech.Blocks.ZianiteLog;
import MinersTech.Blocks.ZondoBlock;
import MinersTech.Blocks.Leaves.ZianiteLeave;
import MinersTech.Blocks.Ores.oreZondo;
import MinersTech.Capes.CapeHandler;
import MinersTech.Capes.DevCapesUtil;
import MinersTech.Crafting.CraftingHandler;
import MinersTech.Generators.TreeManager;
import MinersTech.Handler.FuelHandler;
import MinersTech.Items.DustItems;
import MinersTech.Items.Items;
import MinersTech.Items.MachineBox;
import MinersTech.Items.Fuel.ZianiteCoal;
import MinersTech.Items.Ingots.ingotZondo;
import MinersTech.Items.Tools.ZondoPickaxe;
import MinersTech.Misc.EventManager;
import MinersTech.biomes.BiomeGenBigWoods;
import MinersTech.biomes.BiomeGenTallWoods;
import MinersTech.gui.GuiHandler;
import MinersTech.tileentity.TileEntityMacerator;
import MinersTech.tileentity.TileEntityMinersFurnace;
import MinersTech.tileentity.TileEntityOreGrinder;
import MinersTech.Proxy.*;
import MinersTech.*;
import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import MinersTech.Items.Tools.*;
import MinersTech.Items.Toolsi.CommienitePickaxe;
import net.minecraft.item.EnumArmorMaterial;
import MinersTech.Items.Armor.*;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;

/**
 *
 * @author ZippyBling
 */
@Mod(modid = MinersTech.modid, name = "MinersTech", version = "private-beta-1.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MinersTech {
	public static final String modid = "MinersTech";
	
	@Instance(modid)
	public static MinersTech instance;
        
        
        public static Block blockZondoFurnaceIdle;
        public static Block blockZondoFurnaceActive;
        

        
        public static Block blockZondoChest;
        
		public static Block blockMaceratorIdle;
		public static Block blockMaceratorActive;
		public static Block MachineCasing;
		public static Item MachineBox;
		
		public static Block blockGrinderActive;
		public static Block blockGrinderIdle;
        public static Block blockMinerFurnaceActive;
        public static Block blockMinerFurnaceIdle;
		
        public static Block oreZondo, ZondoBlock, ZondoSlab;
        public static Block ZianiteBlock, CommieniteBlock;
        
        public static Item ingotZondo;
        public static Item ZondoPickaxe, ZondoSword, ZondoShovel, ZondoHoe, ZondoAxe;
        public static Item CommienitePickaxe, CommieniteAxe, CommieniteShovel;
        public static Item ZondoHelmet, ZondoChestplate, ZondoLeggings, ZondoBoots;
        public static Item ZianiteCoal;
       
        public static EnumToolMaterial ZondoPick;
        public static EnumToolMaterial CommienitePick;
        public static EnumArmorMaterial Zondo;
        
        public static Item Dusts;
        
        
        EventManager eventmanager = new EventManager();
        TreeManager treeManager = new TreeManager();
        
        private GuiHandler guiHandler = new GuiHandler();
        
        public static Configuration configuration;

        public static final int guiIdMacerator = 93495;
        public static final int guiIdZondoFurnace = 94596;
        public static final int guiIdblockZondoChest = 94597;
        public static final int guiIdblockOreGrinder = 94598;
        public static final int guiIdblockMinersFurnace = 94599;

        public static BiomeGenBase biomeBigWoods;
        public static BiomeGenBase biomeTallWoods;
       
        public static Block LemonLog;
        public static Block LemonLeaves;
        
        public static Block ZianiteLeave;
        public static Block ZianiteLog;
        
        
        public static int oreZondoI;
        
        public static int MaceratorIdleI;
        
        public static int MaceratorActiveI;
        
        public static int ZondoPickaxeID, ZondoSwordID, ZondoShovelID, ZondoHoeID, ZondoAxeID;
        public static int ZondoHelmetID, ZondoChestplateID, ZondoLeggingsID, ZondoBootsID;
        public static int ingotZondoID;
        public static int ZianiteBlockID;
        public static int CommieniteBlockID;
        public static int oreZondoID;
        
        public static int ZianiteLogID;
        public static int ZianiteCoalID;
        public static int ZianiteLeaveID;
        public static int blockMaceratorIdleID;
        public static int blockMaceratorActiveID;
        public static int MachineBoxID;
        public static int MachineCasingID;
        public static int ZondoBlockID;
        
        public static int IblockGrinderActive;
        public static int IblockGrinderIdle;
        public static int IblockMinerFurnaceActive;
        public static int IblockMinerFurnaceIdle;
       
        public static int IDusts;
        
        public static Block ZirconiumFurnace;
        public static Block ZirconiumFurnaceActive;
       

        public static Achievement GrindEmUp;
        
        public static CreativeTabs MinersTechTab = new CreativeTabs("MinersTech"){
    		public ItemStack getIconItemStack(){
    			return new ItemStack(ZondoBlock);
    		}
    	};
        
        @SidedProxy(clientSide="MinersTech.Proxy.ClientProxy", serverSide="MinersTech.Proxy.ServerProxy")
        public static ServerProxy proxy;
    	
    	@EventHandler
    	public void PreInit(FMLPreInitializationEvent PreEvent){
    		//Cape Stuff
    		DevCapesUtil.addFileUrl("https://raw.githubusercontent.com/ZippyBling/capeFiles/master/SampleCape.txt");
    	}
 public void initConfiguration(FMLInitializationEvent event)
  {
	    Configuration Config = new Configuration(new File("config/ZippyBling/MinersTech.cfg"));
		Config.load();
		
		ZondoPickaxeID = Config.get("Items", "Zondo Pickaxe", 1454).getInt();
		ZondoSwordID = Config.get("Items", "Zondo Sword", 1455).getInt();
		ZondoShovelID = Config.get("Items", "Zondo Shovel", 1456).getInt();
		ZondoHoeID = Config.get("Items", "Zondo Hoe", 1457).getInt();
		ZondoAxeID = Config.get("Items", "Zondo Axe", 1458).getInt();
		ZondoHelmetID = Config.get("Items", "Zondo Helmet", 1459).getInt();
		ZondoChestplateID = Config.get("Items", "Zondo Chestplate", 1460).getInt();
		ZondoLeggingsID = Config.get("Items", "Zondo Leggings", 1461).getInt();
		ZondoBootsID = Config.get("Items", "Zondo Boots", 1462).getInt();
		ingotZondoID = Config.get("Items", "Zondo Ingot", 1453).getInt();
		ZianiteBlockID = Config.get("Blocks", "Zianite Block", 2320).getInt();
		CommieniteBlockID = Config.get("Blocks", "Commienite Block", 2340).getInt();
		oreZondoID = Config.get("Blocks", "Zondo Ore", 2357).getInt();
		ZianiteLogID = Config.get("Blocks", "Zianite Log", 2350).getInt();
		ZianiteCoalID  = Config.get("Items", "Zianite Coal", 1150).getInt();
		ZianiteLeaveID  = Config.get("Blocks", "Zianite Leaves", 2351).getInt();
		blockMaceratorIdleID  = Config.get("Blocks", "Macerator Idle", 2352).getInt();
		blockMaceratorActiveID  = Config.get("Blocks", "Macerator Active", 2353).getInt();
		MachineBoxID  = Config.get("Items", "Machine Box", 1151).getInt();
		MachineCasingID  = Config.get("Blocks", "Machine Casing", 2354).getInt();
		ZondoBlockID  = Config.get("Blocks", "Zondo Block", 2355).getInt();
		IblockGrinderActive = Config.get("Blocks", "Grinder", 3205).getInt();
		IblockGrinderIdle = Config.get("Blocks", "GrinderIdle", 3206).getInt();
		IblockMinerFurnaceActive = Config.get("Blocks", "MinersFurnace", 3207).getInt();
		IblockMinerFurnaceIdle = Config.get("Blocks", "MinersFurnaceIdle", 3208).getInt();
		IDusts = Config.get("Items", "Dusts", 1152).getInt();
		
		Config.save();
        
  }
		
	@EventHandler
	public void load(FMLInitializationEvent event) 
        {
		this.initConfiguration(event);
        LanguageRegistry.instance().addStringLocalization("itemGroup.MinersTech", "MinersTech");	
        
            ZondoPick = EnumHelper.addToolMaterial("ZondoPick", 3, 3651, 30.0F, 19.0F, 55);
            CommienitePick = EnumHelper.addToolMaterial("CommienitePick", 3, 10000, 42.0F, 24.0F, 70);
            Zondo = EnumHelper.addArmorMaterial("Zondo", 3651, new int[] {2, 9, 6, 2}, 55);
                    
	        ZianiteBlock = new ZianiteBlock(MinersTech.ZianiteBlockID, Material.rock).setUnlocalizedName("ZianiteBlock").setCreativeTab(MinersTech.MinersTechTab);
	        CommieniteBlock = new CommieniteBlock(MinersTech.CommieniteBlockID, Material.rock).setUnlocalizedName("CommieniteBlock").setCreativeTab(MinersTech.MinersTechTab);
	        ZianiteLog = new ZianiteLog(MinersTech.ZianiteLogID, Material.wood).setUnlocalizedName("ZianiteLog").setStepSound(Block.soundWoodFootstep).setCreativeTab(MinersTech.MinersTechTab);
	        ZianiteCoal = new ZianiteCoal(MinersTech.ZianiteCoalID).setUnlocalizedName("ZianiteCoal").setCreativeTab(MinersTech.MinersTechTab);;
	        ZianiteLeave = new ZianiteLeave(MinersTech.ZianiteLeaveID, Material.leaves).setUnlocalizedName("ZianiteLeave").setCreativeTab(MinersTech.MinersTechTab)
	        		.setLightOpacity(1000).setLightValue(1.0F).setStepSound(Block.soundGrassFootstep);
	        
            oreZondo = new oreZondo(MinersTech.oreZondoID, Material.rock).setUnlocalizedName("oreZondo").setHardness(3.0F).setCreativeTab(MinersTech.MinersTechTab);
            ingotZondo = new ingotZondo(MinersTech.ingotZondoID).setUnlocalizedName("ingotZondo").setCreativeTab(MinersTech.MinersTechTab);
            ZondoPickaxe = new ZondoPickaxe(MinersTech.ZondoPickaxeID, ZondoPick).setUnlocalizedName("ZondoPickaxe").setCreativeTab(MinersTech.MinersTechTab);
            ZondoAxe = new ZondoAxe(MinersTech.ZondoAxeID, ZondoPick).setUnlocalizedName("ZondoAxe").setCreativeTab(MinersTech.MinersTechTab);
            ZondoShovel = new ZondoShovel(MinersTech.ZondoShovelID, ZondoPick).setUnlocalizedName("ZondoShovel").setCreativeTab(MinersTech.MinersTechTab);
            ZondoHoe = new ZondoHoe(MinersTech.ZondoHoeID, ZondoPick).setUnlocalizedName("ZondoHoe").setCreativeTab(MinersTech.MinersTechTab);
            ZondoSword = new ZondoSword(MinersTech.ZondoSwordID, ZondoPick).setUnlocalizedName("ZondoSword").setCreativeTab(MinersTech.MinersTechTab);
            
            int renderZondoArmor = proxy.addArmor("Zondo");
            ZondoHelmet = new ZondoHelmet(MinersTech.ZondoHelmetID,Zondo, renderZondoArmor, 0).setUnlocalizedName("ZondoHelmet").setCreativeTab(MinersTech.MinersTechTab);
            ZondoChestplate = new ZondoChestplate(MinersTech.ZondoChestplateID,Zondo, renderZondoArmor, 1).setUnlocalizedName("ZondoChestplate").setCreativeTab(MinersTech.MinersTechTab);
            ZondoLeggings = new ZondoLeggings(MinersTech.ZondoLeggingsID,Zondo, renderZondoArmor, 2).setUnlocalizedName("ZondoLeggings").setCreativeTab(MinersTech.MinersTechTab);
            ZondoBoots = new ZondoBoots(MinersTech.ZondoBootsID,Zondo, renderZondoArmor, 3).setUnlocalizedName("ZondoBoots").setCreativeTab(MinersTech.MinersTechTab);
            
            blockMaceratorIdle = new BlockMacerator(MinersTech.blockMaceratorIdleID, false).setUnlocalizedName("macerator_idle").setHardness(3.7F).setStepSound(Block.soundMetalFootstep);
			blockMaceratorActive = new BlockMacerator(MinersTech.blockMaceratorActiveID, true).setUnlocalizedName("macerator_active").setHardness(3.7F).setLightValue(0.9F).setStepSound(Block.soundMetalFootstep);
			MachineBox = new MachineBox(MinersTech.MachineBoxID).setUnlocalizedName("MachineBox").setCreativeTab(MinersTech.MinersTechTab);
			MachineCasing = new MachineCasing(MinersTech.MachineCasingID, Material.iron).setUnlocalizedName("MachineCasing").setStepSound(Block.soundMetalFootstep).setCreativeTab(MinersTech.MinersTechTab);
			ZondoBlock = new ZondoBlock(MinersTech.ZondoBlockID, Material.iron).setUnlocalizedName("ZondoBlock").setStepSound(Block.soundMetalFootstep).setCreativeTab(MinersTech.MinersTechTab);

			blockGrinderIdle = new OreGrinder(IblockGrinderIdle, false).setUnlocalizedName("OreGrinderIdle");
			blockGrinderActive = new OreGrinder(IblockGrinderActive, true).setUnlocalizedName("OreGrinderActive");
			
			blockMinerFurnaceIdle = new MinersFurnace(IblockMinerFurnaceIdle, false).setUnlocalizedName("MinersFurnaceIdle");
			blockMinerFurnaceActive = new MinersFurnace(IblockMinerFurnaceActive, true).setUnlocalizedName("MinersFurnaceActive");
			
		    Dusts = new DustItems(IDusts).setUnlocalizedName("dusts");
		    
		    GameRegistry.registerItem(Dusts, "dusts");
			
			registerBlock(oreZondo, "Zondo Ore");
            registerBlock(ZianiteBlock, "Zianite Brick");
            registerBlock(CommieniteBlock, "CommieniteBlock");
            registerBlock(ZianiteLeave, "Zianite Leaves");
            registerBlock(ZianiteLog, "ZianiteLog");
            registerBlock(blockMaceratorIdle, "Macerator");
            registerBlock(blockMaceratorActive, "Macerator(Active)");
            registerBlock(ZondoBlock, "Zondo Block");
            registerBlock(MachineCasing, "Machine Casing");
            registerBlock(blockGrinderIdle, "Ore Grinder");
            registerBlock(blockGrinderActive, "Ore Grinder");
            registerBlock(blockMinerFurnaceIdle, "Miners Furnace");
            registerBlock(blockMinerFurnaceActive, "Miners Furnace");
            
            registerItem(ingotZondo, "Zondo Ingot");
            registerItem(ZondoPickaxe, "Zondo Pickaxe");
            registerItem(ZondoAxe, "Zondo Axe");
            registerItem(ZondoShovel, "Zondo Shovel");
            registerItem(ZondoHoe, "Zondo Hoe");
            registerItem(ZondoSword, "Zondo Sword");
            registerItem(ZondoHelmet, "Zondo Helmet");
            registerItem(ZondoChestplate, "Zondo Chestplate");
            registerItem(ZondoLeggings, "Zondo Leggings");
            registerItem(ZondoBoots, "Zondo Boots");
            registerItem(ZianiteCoal, "Zianite Coal");
            registerItem(MachineBox, "Machine Box");  
            GameRegistry.registerTileEntity(TileEntityOreGrinder.class, "tileentityoregrinder");
            GameRegistry.registerTileEntity(TileEntityMinersFurnace.class, "tileentityminersfurnace");
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZianiteBlock, 12), new Object[]{
			    " Z ",
			    "ZSZ",
			    " Z ",
				'Z', MinersTech.ingotZondo, 'S', Block.stoneBrick
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.CommieniteBlock, 12), new Object[]{
			    " X ",
			    "ZSZ",
			    " X ",
				'Z', MinersTech.ingotZondo, 'S', Block.stoneBrick, 'X', Item.redstone
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoPickaxe, 1), new Object[]{
			    "ZZZ",
			    " S ",
			    " S ",
				'Z', MinersTech.ingotZondo, 'S', Item.stick
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoAxe, 1), new Object[]{
			    "ZZ ",
			    "ZS ",
			    " S ",
				'Z', MinersTech.ingotZondo, 'S', Item.stick
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoAxe, 1), new Object[]{
			    "ZZZ",
			    " S ",
			    " S ",
				'Z', MinersTech.ingotZondo, 'S', Item.stick
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoShovel, 1), new Object[]{
			    " Z ",
			    " S ",
			    " S ",
				'Z', MinersTech.ingotZondo, 'S', Item.stick
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoHoe, 1), new Object[]{
			    "ZZ ",
			    " S ",
			    " S ",
				'Z', MinersTech.ingotZondo, 'S', Item.stick
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoHoe, 1), new Object[]{
			    " ZZ",
			    " S ",
			    " S ",
				'Z', MinersTech.ingotZondo, 'S', Item.stick
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoSword, 1), new Object[]{
			    " Z ",
			    " Z ",
			    " S ",
				'Z', MinersTech.ingotZondo, 'S', Item.stick
			});
             GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoHelmet, 1), new Object[]{
			    "   ",
			    "ZZZ",
			    "Z Z",
				'Z', MinersTech.ingotZondo
			});
             GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoHelmet, 1), new Object[]{
			    "ZZZ",
			    "Z Z",
			    "   ",
				'Z', MinersTech.ingotZondo
			});
             GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoChestplate, 1), new Object[]{
			    "Z Z",
			    "ZZZ",
			    "ZZZ",
				'Z', MinersTech.ingotZondo
			});
             GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoLeggings, 1), new Object[]{
			    "ZZZ",
			    "Z Z",
			    "Z Z",
				'Z', MinersTech.ingotZondo
			});
              GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoBoots, 1), new Object[]{
			    "   ",
			    "Z Z",
			    "Z Z",
				'Z', MinersTech.ingotZondo
			});
              GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoBoots, 1), new Object[]{
			    "Z Z",
			    "Z Z",
			    "   ",
				'Z', MinersTech.ingotZondo
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.ZondoBlock, 1), new Object[]{
			    "ZZZ",
			    "ZZZ",
			    "ZZZ",
				'Z', MinersTech.ingotZondo
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.MachineCasing, 2), new Object[]{
			    "IZI",
			    "ZBZ",
			    "IZI",
				'Z', MinersTech.ingotZondo, 'B', Block.blockIron, 'I', Item.ingotIron
			});
            GameRegistry.addRecipe(new ItemStack(MinersTech.MachineBox, 4), new Object[]{
			    "SRS",
			    "ZRZ",
			    "SRS",
				'Z', MinersTech.ingotZondo, 'R', Item.redstone, 'S', Item.stick
			});
            
            FurnaceRecipes.smelting().addSmelting(MinersTech.oreZondo.blockID, 0, new ItemStack(MinersTech.ingotZondo), 0.2F);
            FurnaceRecipes.smelting().addSmelting(MinersTech.ZianiteLog.blockID, 0, new ItemStack(MinersTech.ZianiteCoal), 0.2F);
		
            FurnaceRecipes.smelting().addSmelting(MinersTech.Dusts.itemID, 0, new ItemStack(Item.ingotGold), 0.2F);
            FurnaceRecipes.smelting().addSmelting(MinersTech.Dusts.itemID, 1, new ItemStack(Item.ingotIron), 0.2F);
            FurnaceRecipes.smelting().addSmelting(MinersTech.Dusts.itemID, 2, new ItemStack(MinersTech.ingotZondo), 0.2F);
            
			biomeBigWoods = new BiomeGenBigWoods(137).setBiomeName("Big Woods").setDisableRain().setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.4F);
                        biomeTallWoods = new BiomeGenTallWoods(138).setBiomeName("Tall Woods").setDisableRain().setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.4F);
			
			LanguageRegistry.instance().addStringLocalization("container.macerator", "MaceratorMTZ");
		
			NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
			GameRegistry.registerCraftingHandler(new CraftingHandler());

                        
                        GameRegistry.registerWorldGenerator(eventmanager);
                        GameRegistry.registerWorldGenerator(treeManager);
                        GameRegistry.registerFuelHandler(new FuelHandler());
                        GameRegistry.registerTileEntity(TileEntityMacerator.class, "MaceratorMTZ");
                        GameRegistry.addBiome(biomeBigWoods);
                        GameRegistry.addBiome(biomeTallWoods);
                        
                        
                        OreDictionary.registerOre("ingotZondo", ingotZondo);
                        OreDictionary.registerOre("oreZondo", oreZondo);
                        OreDictionary.registerOre("logZianite", ZianiteLog);
                        OreDictionary.registerOre("coalZianite", ZianiteCoal);

                        GrindEmUp = new Achievement(4503, "GrindEmUp", 0, 0, MinersTech.blockGrinderIdle, null).registerAchievement();
                        this.addAchievementName("GrindEmUp", "Ginrd Em Up!");
                        this.addAchievementDesc("GrindEmUp", "You Crafted Your First Grinder!");



        }
	private void addAchievementName(String ach, String name)
	{
	LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}

	private void addAchievementDesc(String ach, String desc)
	{
	LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}

        public static void registerBlock(Block block, String name){
            GameRegistry.registerBlock(block, block.getUnlocalizedName());
            LanguageRegistry.addName(block, name);
        }
        
        public static void registerItem(Item item, String name){
            GameRegistry.registerItem(item, item.getUnlocalizedName());
            LanguageRegistry.addName(item, name);
        	}


};
    	

